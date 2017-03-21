import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MessageModal extends HttpServlet {
	public static String inbox (HttpServletResponse res, String from)  throws IOException {
		String html = "";

       //WriteModal
        html += "<div class='modal fade' id='WriteModal' role='dialog'><div class='modal-dialog'>";

        //Modal content
        html += "<div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Send a message to <span id='sperson'></span></h4></div>";
        html += "<div class='modal-body'><form role='form' id='messageForm' action=''><div class='form-group'><label for='from'>From:</label><input type='text' class='form-control' id='from' value='"+from+"' readonly=''></div><div class='form-group'><label for='to'>To:</label><input type='text' class='form-control' id='to' readonly=''></div><textarea class='form-control' rows='5' id='textMessage' placeholder='Write your message here...' ></textarea></form></div>";
        html += "<div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'><a href='#'>Close</a></button><button type='button' id='bsend' class='btn btn-primary' onclick='createMessage()'>Send message</button></div></div>";

        //End Modal
        html += "</div></div>";

        //SentModal
        html += "<div class='modal fade' id='SentModal' role='dialog'><div class='modal-dialog'>";

        //Modal content
        html += "<div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Message sent</h4></div>";
        html += "<div class='modal-body'><p>Your message to <span id='rperson'></span> has been sent successfully.</p></div>";
        html += "<div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'><a href='#'>Close</a></button></div></div>";

        //End Modal
        html += "</div></div>";
        return html;
	}
    public static String invite (HttpServletResponse res, String group, String[] arrayFriends, int lengthFriends)  throws IOException {
        String html = "";

       //WriteModal
        html += "<div class='modal fade' id='WriteModal' role='dialog'><div class='modal-dialog'>";

        //Modal content
        html += "<div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Invite friends to "+group+"</h4></div>";
        html += "<div class='modal-body'><form role='form' id='inviteForm' action='sendInvitations'><div class='form-group'><label for='group'>Send invitations to the group:</label><input type='text' class='form-control' id='group' name='group' value='"+group+"' readonly=''></div>";
        for(int i=0;i<lengthFriends;i++){
            html += "<div class='checkbox'><label><input type='checkbox' name='friend' value='"+arrayFriends[i]+"'>"+arrayFriends[i]+"</span></label>";
        }
        html += "</form></div>";
        html += "<div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'><a href='#'>Close</a></button><button type='button' id='bsend' class='btn btn-primary' onclick='sendInvitation()'>Send invitations</button></div></div>";

        //End Modal
        html += "</div></div>";
        return html;
    }
    public static String invited (HttpServletResponse res, String group)  throws IOException {
        String html = "";
        //SentModal
        html += "<div class='modal fade' id='SentModal' role='dialog'><div class='modal-dialog'>";

        //Modal content
        html += "<div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Invitations sent</h4></div>";
        html += "<div class='modal-body'><p>Your invitations to "+group+" have been sent successfully.</p></div>";
        html += "<div class='modal-footer'><button type='button' class='btn btn-default' onclick='backToGroups()'>Close</button></div></div>";

        //End Modal
        html += "</div></div>";
        return html;
    }
}