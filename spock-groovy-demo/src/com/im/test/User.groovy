package com.im.test


class User {
    PasswordEncrypterService passwordEncrypterService = new PasswordEncrypterService()
    EmailService emailService = new EmailService()

    String username
    String password
    String firstName
    String lastName

    String gender = "Male"
    BigDecimal balance
    List<Product> purchasedProducts = []
    Boolean isPrivellegedCustomer
    BigDecimal incomePerMonth


    String getGender() {
        return gender
    }

    void setGender(String gender) {
        if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
            this.gender = gender
        }else{
            throw new IllegalArgumentException("Gender values accepted are not accepted.")
        }
    }

    String getFullName() {
        return firstName + " " + lastName
    }

    String displayName() {
        String prefix = (gender == "Male") ? 'Mr ' : 'Ms '
        return prefix + fullName
    }

    Boolean isValidPassword(String pwd) {
        Boolean isValid = false
        if (pwd && pwd.length() > 7) {
            isValid = true
        }
        return isValid
    }

    String resetPasswordAndSendEmail() {
        String newPassword = "dummy"
        this.password = encryptPassword(newPassword)
        emailService.sendCancellationEmail(this, newPassword)

    }

    String encryptPassword(String pwd) {
        String encryptedPassword
        if (this.isValidPassword(pwd)) {
            encryptedPassword = passwordEncrypterService.encrypt(pwd)
        }
        return encryptedPassword
    }


    String getIncomeGroup() {
        String group
        if (this.incomePerMonth <= 5000) {
            group = "MiddleClass"
        } else if (incomePerMonth > 5000 && incomePerMonth <= 10000) {
            group = "Lower MiddleClass"
        } else if (incomePerMonth > 10000) {
            group = "Upper MiddleClass"
        }
        return group
    }


    void purchase(Product p) {
        if (p) {
            purchasedProducts.add(p)
        }
    }

    void cancelPurchase(Product p) {
        if (p) {
            purchasedProducts.remove(p)
        }
    }

    List<String>getSortedInterestedInCategories(){
        List<String> interestedInCategories = getInterestedInCategories()
        interestedInCategories.sort()
    }

    List<String>getInterestedInCategories(){    //assumed to be a very complex method
        sleep(10000)
    }

}
