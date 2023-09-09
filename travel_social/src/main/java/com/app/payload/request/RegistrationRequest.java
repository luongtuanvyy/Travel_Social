package com.app.payload.request;

import com.app.entity.Account;
import com.app.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private Account account;
    private Users users;
}
