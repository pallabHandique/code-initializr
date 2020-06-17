package com.codeinitializr.controllers;

import javax.validation.Valid;

import com.codeinitializr.payloads.ChangePasswordPayload;
import com.codeinitializr.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 */
@RestController
public class UserController {

    @Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = { "/user/page-change-password" })
	public ModelAndView changePassword(ModelAndView mv) {
		mv = new ModelAndView("logged/change_password");
		return mv;
	}

	// @PutMapping(value = "/user/put-change-password")
	// public ResponseEntity<JsonResponse> postChangePassword(@Valid @ModelAttribute ChangePasswordPayload changePasswordPayload,
	// 		BindingResult bindingResult) throws BindException {

	// 	JsonResponse res = new JsonResponse();

	// 	if (bindingResult.hasErrors()) {
	// 		throw new BindException(bindingResult);
	// 	}

	// 	User user = userService.findUserByUsername(LoggedInUser.getLoggedInUsername()).get();

	// 	if(!(bCryptPasswordEncoder.matches(changePassword.getOldPassword(), user.getPassword()))) {
	// 			bindingResult.rejectValue("oldPassword","error.oldPassword", "*Incorrect old password");
	// 	}

	// 	PasswordUtility passwordUtility = new PasswordUtility();
	// 	String passwordStrength = passwordUtility.validateNewPass(changePassword.getNewPassword(), changePassword.getConfirmPassword());
	// 	if(!(Objects.equal(passwordStrength, "SUCCESS"))) {
	// 		bindingResult.rejectValue("passwordStrength","error.passwordStrength", passwordStrength);
	// 	}

	// 	if (!bindingResult.hasErrors()) {
	// 		String bCryptHashedPassword = bCryptPasswordEncoder.encode(changePassword.getNewPassword());
	// 		user.setPassword(bCryptHashedPassword);
	// 		userService.save(user);

	// 		res.setMessage("Password Changed Successfully");
	// 		res.setResult(true);
    //         return ResponseEntity.ok(res);
    //     } else {
    //         throw new BindException(bindingResult);
    //     }
		
	// }
}