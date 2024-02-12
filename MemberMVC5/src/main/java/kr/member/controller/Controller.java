package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
