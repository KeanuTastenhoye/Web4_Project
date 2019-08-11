package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetArticle extends SynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> articles = this.getArticles(6);
        String articleNrStr = request.getParameter("articleNr");
        int articleNr = Integer.parseInt(articleNrStr);

        if (!(articles.get(articleNr - 1) == null)) {
            request.getRequestDispatcher("article" + articleNr + ".jsp").forward(request, response);
        }
        return "index.jsp";
    }

    private List<String> getArticles(int length) {
        List<String> articles = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String iStr = "" + i;
            articles.add(iStr);
        }

        return articles;
    }
}
