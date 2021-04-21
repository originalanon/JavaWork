package LightBeams;

public class EastSplitterBlock extends LightBlocks{

	public String getName() {
		return ">";
	}
	
	public java.awt.Color getNameColor() {
		return java.awt.Color.magenta;
	}
	 
	public Illumination illuminate (Illumination input)
    {
		
		float newBlue;
		float newGreen;
		float newRed;
		float newBrightness;
		//resets the new colors to 0;
		newBlue = newRed = newGreen = newBrightness = 0;
		
		Illumination result = new Illumination();
		
		//checks if light is coming from the north and south, and redirects them to the east
		if((input.N.brightness() > 0) && (input.S.brightness() > 0)) {
			
			newBlue = input.N.getBlue() + input.S.getBlue();
			newGreen = input.N.getGreen() + input.S.getGreen();;
			newRed = input.N.getRed() + input.S.getRed();;
			
			result.N = new LightColor();
			result.S = new LightColor();
			result.W = new LightColor();
			result.E = new LightColor(newRed, newGreen, newBlue);
		}
		else {
			newBrightness = input.E.brightness() / 2;
			
			result.N = input.E.scale(newBrightness);
			result.S = input.E.scale(newBrightness);
			result.E = new LightColor();
			result.W = new LightColor();
		}
		
		return result;
    }
	
	public String getCategory() {return "Splitters";}
	
}