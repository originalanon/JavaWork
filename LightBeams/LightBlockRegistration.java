package LightBeams;


public class LightBlockRegistration
{

    /**
     *  Each kind of LightBlock must be registered so that the GUI
     *  will know that it exists
     */
    

    public static void doRegistrations (Registerable r)
    {
	tryRegistration (new TransparentBlock(), r);
	tryRegistration (new RedFlashlightBlock(), r);
	tryRegistration (new BlueFlashlightBlock(), r);
	tryRegistration (new GreenFlashlightBlock(), r);
	tryRegistration (new RedFilterBlock(), r);
	tryRegistration (new BlueFilterBlock(), r);
	tryRegistration (new GreenFilterBlock(), r);
	tryRegistration (new MirrorLLURBlock(), r);
	tryRegistration (new MirrorULLRBlock(), r);
	tryRegistration (new OpaqueBlock(), r);
	tryRegistration (new EastSplitterBlock(), r);
	tryRegistration (new WestSplitterBlock(), r);
	tryRegistration (new NorthSplitterBlock(), r);
	tryRegistration (new SouthSplitterBlock(), r);
	// Add additional registrations as necessary
    }
    
    private static void tryRegistration (LightBlocks sample, Registerable r)
    {
	r.register (sample, sample.getCategory());
    }
    

}
