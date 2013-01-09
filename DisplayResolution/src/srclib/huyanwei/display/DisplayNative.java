package srclib.huyanwei.display;

public class DisplayNative {
	static 
	{
		System.loadLibrary("display_jni");
	};	
	static native int get_framebuffer_info_init();
	static native int get_framebuffer_info_width();
	static native int get_framebuffer_info_height();
	static native int get_framebuffer_info(int[] width,int[] height);
	static native int get_framebuffer_info_deinit();
}
