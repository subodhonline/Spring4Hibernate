$(document).ready(function() {
	//bootstrap adding attribute multiple by default to remove that attribute removeAttr () is used
	$("#role").removeAttr("multiple");
	var createUserObject = new createUser();
	createUserObject.init();
});


var createUser = function() {

    privateMethod = {
    	attachEventHandler : function(){
    		$( "#submit" ).click(function() {
    			COMMAN_METHOD.clearElementValue("firstNameMessage");
    			COMMAN_METHOD.clearElementValue("lastNameMessage");
    			COMMAN_METHOD.clearElementValue("emailMessage");
    			COMMAN_METHOD.clearElementValue("passwordMessage");
    			COMMAN_METHOD.clearElementValue("roleMessage");
    			
    			var isErrorOccurred = false;
    			var firstName = $('#firstName').val().trim();
    			var lastName = $('#lastName').val().trim();
    			var email = $('#email').val().trim();
    			var password = $('#password').val();
    			var role = $('#role').val();

    			if(firstName.length === 0){
    				COMMAN_METHOD.appendMessageToElement("firstNameMessage", MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD);
    				isErrorOccurred = true;
    			}
    			if(lastName.length === 0){
    				COMMAN_METHOD.appendMessageToElement("lastNameMessage", MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD);
    				isErrorOccurred = true;
    			}
    			if(email.length === 0){
    				COMMAN_METHOD.appendMessageToElement("emailMessage", MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD);
    				isErrorOccurred = true;
    			}
    			if(password.length === 0){
    				COMMAN_METHOD.appendMessageToElement("passwordMessage", MESSAGE_CONSTANT.MESSAGE_REQUIRED_FIELD);
    				isErrorOccurred = true;
    			}
    			if(role == -1){
    				COMMAN_METHOD.appendMessageToElement("roleMessage", MESSAGE_CONSTANT.MESSAGE_SELECT_ROLE);
    				isErrorOccurred = true;
    			}
    			
    			if(!isErrorOccurred){
    				if(!COMMAN_METHOD.isValidName(firstName)){
    					COMMAN_METHOD.appendMessageToElement("firstNameMessage", MESSAGE_CONSTANT.MESSAGE_SPECIAL_CHARACTER_NOT_ALLOWED);
        				isErrorOccurred = true;
    				}
    				if(!COMMAN_METHOD.isValidName(lastName)){
    					COMMAN_METHOD.appendMessageToElement("lastNameMessage", MESSAGE_CONSTANT.MESSAGE_SPECIAL_CHARACTER_NOT_ALLOWED);
        				isErrorOccurred = true;
    				}
    				if(password.length < 6){
        				COMMAN_METHOD.appendMessageToElement("passwordMessage", MESSAGE_CONSTANT.MESSAGE_PASSWORD_LESS_THAN_SIX_CHARACTERS);
        				isErrorOccurred = true;
        			}
    				if(!COMMAN_METHOD.isValidEmailAddress(email)){
    					COMMAN_METHOD.appendMessageToElement("emailMessage", MESSAGE_CONSTANT.MESSAGE_ENTER_VALID_EMAIL);
        				isErrorOccurred = true;
    				}
    			}
    		   if(!isErrorOccurred){
    			   $("#createUserForm").submit();
    		   }
    		   else{
    			   return false;
    		   }
			});
    		
    	},
    	
    	displayMessages : function(){
    		if($("#successMessage").val().length > 0){
    			$().toastmessage('showSuccessToast', $("#successMessage").val());
    		}
    	},
    };

    return{
        init: function() {
        	privateMethod.attachEventHandler();
        	privateMethod.displayMessages();
        }
    };
};


