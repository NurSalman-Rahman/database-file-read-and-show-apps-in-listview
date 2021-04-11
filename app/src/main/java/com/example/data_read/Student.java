package com.example.data_read;

public class Student {

  String otp_id ;
    String mobile;
    String otp;
    String status;
    String reference;
    String date;


/*    public Student(String otp_id, String mobile, String otp, String status, String reference, String date) {
        this.otp_id = otp_id;
        this.mobile = mobile;
        this.otp = otp;
        this.status = status;
        this.reference = reference;
        this.date = date;
    }*/


    // 3 data pass
/*    public Student(String otp_id, String mobile, String otp) {
        this.otp_id = otp_id;
        this.mobile = mobile;
        this.otp = otp;
    }*/


    // 4 data pass
    public Student(String otp_id, String mobile, String otp, String status) {
        this.otp_id = otp_id;
        this.mobile = mobile;
        this.otp = otp;
        this.status = status;
    }

    public String getOtp_id() {
        return otp_id;
    }

    public void setOtp_id(String otp_id) {
        this.otp_id = otp_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
