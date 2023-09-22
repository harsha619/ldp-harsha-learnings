package com.sso.security.dto;


import com.sso.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    Long id;
    String email;
    String password;
    String name;
    String address;
    String department;
    String role;

    @Autowired
    private static ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
    }

    public static User convertDtoToEntity(UserDto UserDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(UserDTO, User.class);
    }
    public static UserDto convertEntityToDto(User User) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(User, UserDto.class);
    }

}
