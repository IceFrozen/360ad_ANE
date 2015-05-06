package com.clodynetsky.wuxiaAd;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.clodynetsky.wuxiaAdutil.AppData;
import com.mediav.ads.sdk.adcore.MediavAdEventListener;
import com.mediav.ads.sdk.adcore.MediavAdView;
import com.mediav.ads.sdk.adcore.MediavSimpleAds;

public class MediaAdFunction implements FREFunction {
	
	private MediavAdView mediavAdView = null;
	private FREContext _context;
	private  String TAG;
	
	public MediaAdFunction() {
		this.TAG = AppData.InitAdFunction_Tag;;	
	}

	@Override
	public FREObject call(FREContext context, FREObject[] arg1) {
		_context = context;
		String b = "newGet";
		boolean isTest = false;
		try {
			b = arg1[0].getAsString();
			isTest = arg1[1].getAsBool();
		} catch (Exception e) {
			
		}
		//true : º”‘ÿπ„∏Ê
		if("newGet".equals(b)){
			mediavAdView = MediavSimpleAds.initSimpleInterstitial(context.getActivity(), AppData.adSpeadId, isTest);
			mediavAdView.setAdEventListener(new mediaLister());	
		}else if("reflush".equals(b)){
			/*if(null !=mediavAdView){
				mediavAdView = MediavSimpleAds.reloadInterstitial(context.getActivity());
			}*/
		}else if("close".equals(b)){
			if(null !=mediavAdView){
				mediavAdView.closeAds();
			}
		}else if("open".contains(b)){
			if(null !=mediavAdView){
				mediavAdView.showAds(context.getActivity());
			}
		} 
		return null;
	}
	
	class  mediaLister implements MediavAdEventListener  {

		@Override
		public void onAdviewClicked(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewClosed(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewDestroyed(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewDismissedLandpage(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewGotAdFail(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewGotAdSucceed(MediavAdView arg0) {
			
		}

		@Override
		public void onAdviewIntoLandpage(MediavAdView arg0) {
			
		}
		
	}

}
