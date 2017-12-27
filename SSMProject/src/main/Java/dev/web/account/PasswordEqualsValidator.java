package dev.web.account;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordEqualsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return dev.web.account.AccountForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		dev.web.account.AccountForm form = (dev.web.account.AccountForm) target;
		String password = form.getPassword();
		String repeatedPassword = form.getRepeatedPassword();
		if (password == null || repeatedPassword == null) {
			return;
		}
		if (!password.equals(repeatedPassword)) {
			errors.rejectValue("password",
					"PasswordEqualsValidator.accountForm.password",
					"密码不一致, 请重新输入");
		}
	}
}
