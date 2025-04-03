package com.example.MediCure.exception;

public class ResourceNotFoundException extends RuntimeException {
String resourceName;
String resourceField;
Integer fieldName;
public ResourceNotFoundException(String resourceName, String resourceField, Integer fieldName) {
	super(String.format("%s not found with %s: %s", resourceName,resourceField,fieldName));
	this.resourceName = resourceName;
	this.resourceField = resourceField;
	this.fieldName = fieldName;
}



}
