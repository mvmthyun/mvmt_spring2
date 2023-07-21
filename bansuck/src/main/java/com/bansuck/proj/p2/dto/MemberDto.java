package com.bansuck.proj.p2.dto;

import java.util.Date;

public class MemberDto {

    private String memberId; // 아이디
    private String memberPassword; // 패스워드
    private String memberEmail; // 이메일
    private String memberName; // 이름
    private String memberNumber; // 연락처
    private String memberAddr; // 주소
    private Date memberCreateAt; // 생성일자
    private Date memberModifiedAt; // 수정일자
    private String memberActivation; // 활성화/비활성화
    
    public MemberDto() { this("", "", ""); }
    public MemberDto(String memberId, String memberPassword, String memberEmail) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
    }

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPassword() {
        return memberPassword;
    }
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
    public String getMemberEmail() {
        return memberEmail;
    }
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    public String getMemberAddr() {
        return memberAddr;
    }
    public void setMemberAddr(String memberAddr) {
        this.memberAddr = memberAddr;
    }
    public Date getMemberCreateAt() {
        return memberCreateAt;
    }
    public void setMemberCreateAt(Date memberCreateAt) {
        this.memberCreateAt = memberCreateAt;
    }
    public Date getMemberModifiedAt() {
        return memberModifiedAt;
    }
    public void setMemberModifiedAt(Date memberModifiedAt) {
        this.memberModifiedAt = memberModifiedAt;
    }
    public String getMemberActivation() {
        return memberActivation;
    }
    public void setMemberActivation(String memberActivation) {
        this.memberActivation = memberActivation;
    }
    
    @Override
    public String toString() {
        return "MemberDto [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberEmail=" + memberEmail
                + ", memberName=" + memberName + ", memberNumber=" + memberNumber + ", memberAddr=" + memberAddr
                + ", memberCreateAt=" + memberCreateAt + ", memberModifiedAt=" + memberModifiedAt
                + ", memberActivation=" + memberActivation + "]";
    }
    
}
