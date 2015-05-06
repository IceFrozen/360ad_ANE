package com.clodynetsky.wuxiaAd;

import java.util.Map;


import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.clodynetsky.wuxiaAdutil.AppData;
import com.mediav.ads.sdk.adcore.MediavAdView;
import com.mediav.ads.sdk.adcore.MediavSimpleAds;

public class CenterBanner  extends FREContext{

	@Override
	public void dispose() {
		MediavSimpleAds.unregisterMediavReceiver(this.getActivity());
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String,FREFunction> functionMap=new java.util.HashMap<String,FREFunction>();
		functionMap.put("mediaAd", new MediaAdFunction());
		functionMap.put("BannerAd", new BannerAdFunction());
		return functionMap;
	}

}
