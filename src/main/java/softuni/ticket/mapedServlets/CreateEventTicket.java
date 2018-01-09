package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

import softuni.ticket.Utils;
import softuni.ticket.JDBC.QueryManagerImpl;
import softuni.ticket.JDBC.interfaces.QueryManager;

public class CreateEventTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	// location to store file uploaded
//	private static final String UPLOAD_DIRECTORY = "upload";
//
//	// upload settings
//	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
//	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
//	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("eventName");
		String location = req.getParameter("eventLocation");
		String dateSTR = req.getParameter("eventDate");
		int ticketsAmmount = Integer.parseInt(req.getParameter("ticketsAmmount"));
		String eventInfo = req.getParameter("eventInfo");
		BigDecimal ticketPrice = new BigDecimal(req.getParameter("ticketPrice"));
		QueryManager manager = new QueryManagerImpl();
		Date date = Utils.toDate(dateSTR);
		
		try {
			//this.fileUploading(req, resp);
			date = new SimpleDateFormat("dd-MMM-yyyy").parse(req.getParameter("eventDate"));
			manager.insertTicket(name, location, date, ticketsAmmount, eventInfo, ticketPrice);

 		} catch (ParseException | SQLException  e) {
			Utils.jsonErrorMessage(e);
		}
	}
	
//	private void fileUploading(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//
//		if (!ServletFileUpload.isMultipartContent(req)) {
//			// if not, we stop here
//			PrintWriter writer = resp.getWriter();
//			writer.println("Error: Form must has enctype=multipart/form-data.");
//			writer.flush();
//			return;
//		}
//		
//		 // configures upload settings
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        // sets memory threshold - beyond which files are stored in disk
//        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        // sets temporary location to store files
//        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
// 
//        ServletFileUpload upload = new ServletFileUpload(factory);
//         
//        // sets maximum and size of upload file
//        upload.setFileSizeMax(MAX_FILE_SIZE);
//        // sets maximum size of request (include file + form data)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
// 
//        // constructs the directory path to store upload file
//        // this path is relative to application's directory
//        String uploadPath = getServletContext().getRealPath("")
//                + File.separator + UPLOAD_DIRECTORY;
//         
//        // creates the directory if it does not exist
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
// 
//        try {
//            // parses the request's content to extract file data
//            List<FileItem> formItems = upload.parseRequest(req);
// 
//            if (formItems != null && formItems.size() > 0) {
//                // iterates over form's fields
//                for (FileItem item : formItems) {
//                    // processes only fields that are not form fields
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
// 
//                        // saves the file on disk
//                        item.write(storeFile);
//                        req.setAttribute("message",
//                            "Upload has been done successfully!");
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            req.setAttribute("message",
//                    "There was an error: " + ex.getMessage());
//        }
//	}
}
