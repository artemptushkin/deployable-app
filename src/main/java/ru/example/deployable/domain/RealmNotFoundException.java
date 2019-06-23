package ru.example.deployable.domain;

public class RealmNotFoundException extends RuntimeException {
	public RealmNotFoundException() {
		super("RealmNotFound");
	}
}
