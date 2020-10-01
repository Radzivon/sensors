package by.radzivon.sensors.dto.auth;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
