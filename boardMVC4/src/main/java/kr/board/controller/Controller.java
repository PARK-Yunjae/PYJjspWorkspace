package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException;
}
