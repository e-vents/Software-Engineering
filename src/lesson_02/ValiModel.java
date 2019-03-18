package lesson_02;

public class ValiModel {

	public boolean isValidIp(String newValue) {
		boolean valid = false;
		
		String[] addressParts = newValue.split("\\.", -1);
	
		if(addressParts.length == 4) {
			valid = true;
			for(String addressPart : addressParts) {
				try {
					int i = Integer.parseInt(addressPart);
					
					if(i > 255 || i <= 0)
						valid = false;
						
				} catch(NumberFormatException exc) {
					valid = false;
				}		
			}
		}
		/*
		if(!valid) {
			if(addressParts.length >= 2) {
				valid = true;
				for(String parts : addressParts) {
					if(parts.length() < 2)
						valid = false;
				}
			}
		}
		*/
		return valid;
		
	}
	
	public boolean isValidPort(String newValue) {
		boolean valid = false;
		
		try {
			int port = Integer.parseInt(newValue);
			if(port < 65535 && port > 0)
				valid = true;
			
		} catch(NumberFormatException exc) {
			valid = false;
		}
		
		return valid;
	}
}
