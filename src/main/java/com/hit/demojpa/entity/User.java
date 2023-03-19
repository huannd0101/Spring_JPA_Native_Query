package com.hit.demojpa.entity;

import com.hit.demojpa.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

// 1. @NamedNativeQuery
// name: Là tên method của repository
// query: Là query tự tạo ra để trả về object Dto
// resultSetMapping: Là tên của resultMapping bên dới được định nghĩa với anotation @SqlResultSetMapping

// 2. @SqlResultSetMapping
// name: Là tên của result map
// classes: Định nghĩa class được map tới với targetClass và các column được định nghĩa trong columns
@NamedNativeQuery(name = "User.findByUsername",
    query = "SELECT u.id as id, u.username as username FROM Users u WHERE u.username = :username",
    resultSetMapping = "Mapping.UserDto")
@SqlResultSetMapping(
    name = "Mapping.UserDto",
    classes = @ConstructorResult(
        targetClass = UserDto.class,
        columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "username", type = String.class)
        }))
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

}
