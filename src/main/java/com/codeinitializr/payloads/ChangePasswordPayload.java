package com.codeinitializr.payloads;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class ChangePasswordPayload {

	@NotBlank(message = "* Please provide your old password.")
	public String oldPassword;

	@NotBlank(message = "* Please provide your new password.")
	public String newPassword;

	@NotBlank(message = "* Please re-type your new password.")
	public String confirmPassword;

	public String passwordStrength;


    public ChangePasswordPayload() {
    }

    public ChangePasswordPayload(String oldPassword, String newPassword, String confirmPassword, String passwordStrength) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.passwordStrength = passwordStrength;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPasswordStrength() {
        return this.passwordStrength;
    }

    public void setPasswordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength;
    }

    public ChangePasswordPayload oldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public ChangePasswordPayload newPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public ChangePasswordPayload confirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public ChangePasswordPayload passwordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChangePasswordPayload)) {
            return false;
        }
        ChangePasswordPayload changePasswordPayload = (ChangePasswordPayload) o;
        return Objects.equals(oldPassword, changePasswordPayload.oldPassword) && Objects.equals(newPassword, changePasswordPayload.newPassword) && Objects.equals(confirmPassword, changePasswordPayload.confirmPassword) && Objects.equals(passwordStrength, changePasswordPayload.passwordStrength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldPassword, newPassword, confirmPassword, passwordStrength);
    }

    @Override
    public String toString() {
        return "{" +
            " oldPassword='" + getOldPassword() + "'" +
            ", newPassword='" + getNewPassword() + "'" +
            ", confirmPassword='" + getConfirmPassword() + "'" +
            ", passwordStrength='" + getPasswordStrength() + "'" +
            "}";
    }

}