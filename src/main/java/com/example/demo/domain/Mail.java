package com.example.demo.domain;

import java.util.List;
import java.util.Map;

public class Mail {

    private List<String> to;
    
    private List<String> cc;
    
    private String subject;
    
    private String text;
    
    private Map<String, byte[]> attachmentMap;

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, byte[]> getAttachmentMap() {
        return attachmentMap;
    }

    public void setAttachmentMap(Map<String, byte[]> attachmentMap) {
        this.attachmentMap = attachmentMap;
    }
    
}
