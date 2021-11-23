package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = null;
		
		//actionの値をリクエストパラメータから取得
		String action = request.getParameter("action");
		
		//登録開始時の処理
		if(action == null) {
			//登録フォームを呼び出し
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}else if(action.equals("done")) {
			//セッションスコープに登録ユーザーを格納
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");
			
			// 登録処理を呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			//セッションスコープの削除
			session.removeAttribute("registerUser");
			
			//登録後画面に遷移
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
		//フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//登録ユーザーインスタンスを作成し、パラメータを格納
		User registerUser = new User(id, name, pass);
		
		//セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		//確認画面へフォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
		}

}
