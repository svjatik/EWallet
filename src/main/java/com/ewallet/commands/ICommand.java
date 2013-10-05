package com.ewallet.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Svjatoslav Glushchenko
 * Date: 10/5/13
 */
public interface ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
