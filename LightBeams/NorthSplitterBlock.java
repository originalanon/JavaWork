package LightBeams;

public class NorthSplitterBlock extends LightBlocks{

	public String getName() {
		return "^";
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
		
		//checks if light is coming from the east and west, and redirects them to the north
		if((input.E.brightness() > 0) && (input.W.brightness() > 0)) {
			
			//figures out what the new color should be
			newBlue = input.W.getBlue() + input.E.getBlue();
			newGreen = input.W.getGreen() + input.E.getGreen();
			newRed = input.W.getRed() + input.E.getRed();
			
			
			result.N = new LightColor(newRed, newGreen, newBlue);
			//result.N = input.E;
			result.S = new LightColor();
			result.W = new LightColor();
			result.E = new LightColor();
		}
		else {
			//figures out the new brightness
			newBrightness = input.N.brightness() / 2;
			
			result.N = new LightColor();
			result.S = new LightColor();
			result.E = input.N.scale(newBrightness);
			result.W = input.N.scale(newBrightness);
		}
		
		return result;
    }
	
	public String getCategory() {return "Splitters";}
	
}