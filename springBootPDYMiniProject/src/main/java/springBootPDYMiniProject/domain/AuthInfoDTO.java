package springBootPDYMiniProject.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import springBootPDYMiniProject.domain.AuthInfoDTO;

@Data
@Alias("auth")
public class AuthInfoDTO {
	String userId;
	String userPw;
	String userName;
	String userEmail;
	String grade;
}
