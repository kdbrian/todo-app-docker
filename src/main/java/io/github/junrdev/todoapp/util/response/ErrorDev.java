package io.github.junrdev.todoapp.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDev {
    private String message;
    private int code;
    private String timestamp;
    private String trace;
}
