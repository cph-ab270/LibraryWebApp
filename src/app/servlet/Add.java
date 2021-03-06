package app.servlet;

import app.model.Model;
import app.model.entity.Item;
import app.model.repository.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by adam on 20/01/2017.
 */
@WebServlet(name = "Add")
public class Add extends Servlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            Model model = Model.getInstance();
            ItemRepository itemRepository = model.getItemRepository();
            Item item = new Item();
            item.setName(request.getParameter("name"));
            item.setDescription(request.getParameter("description"));
            item.setCategoryId(Integer.parseInt(request.getParameter("category")));
            item.setImg("jungle.jpg");
            itemRepository.persistAndFlush(item);
            request.setAttribute("alert", "Book with id "+item.getId()+" was added.");
        }
        renderTemplate(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderTemplate(request,response);
    }
}
