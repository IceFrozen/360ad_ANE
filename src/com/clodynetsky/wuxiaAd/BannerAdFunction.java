package com.clodynetsky.wuxiaAd;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.clodynetsky.wuxiaAdutil.AppData;
import com.mediav.ads.sdk.adcore.MediavAdView;
import com.mediav.ads.sdk.adcore.MediavSimpleAds;
import com.mediav.ads.sdk.adcore.MvBannerAd;
import com.mediav.ads.sdk.adcore.MvInterstitialAd;

public class BannerAdFunction implements FREFunction {
	/**
	 * 横幅广告
	 */
	private MediavAdView mediavAdView = null;
	private RelativeLayout adContainer = null;
	private LayoutParams layoutParams = null;
	private FREContext _context;
	private  String TAG;
	
	public BannerAdFunction() {
		//this.TAG = AppData.InitAdFunction_Tag;
		//TODO
		//动态创建布局
		layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	}

	@Override
	public FREObject call(FREContext context, FREObject[] arg1) {
		_context = context;
		adContainer = new RelativeLayout(context.getActivity());
		adContainer.setLayoutParams(layoutParams);
		context.getActivity().addContentView(adContainer, layoutParams);
		String model = "newGet";
		boolean isTest = false;
		try {
			model = arg1[0].getAsString();
			isTest = arg1[1].getAsBool();
		} catch (Exception e) {
			
		}
		//true : 加载广告
		if(("newGet".equals(model))){
			
			mediavAdView =  MediavSimpleAds.initSimpleBanner(adContainer, context.getActivity(), AppData.adSpeadId, isTest);
			
		}else if(("open".equals(model))){
			//关闭广告
			if(null ==mediavAdView){
				mediavAdView =  MediavSimpleAds.initSimpleBanner(adContainer, context.getActivity(), AppData.adSpeadId, isTest);
			}else{
				mediavAdView.showAds(context.getActivity());
			}
		}else if("reflush".equals(model)){
			/*if(null !=mediavAdView){
				mediavAdView = MediavSimpleAds.reloadInterstitial(context.getActivity());
			}*/
		}
		else if("close".equals(model)){
			if(null !=mediavAdView){
				mediavAdView.closeAds();
				
			}
		}
		return null;
	}
}
