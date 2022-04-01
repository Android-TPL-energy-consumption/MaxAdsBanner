package tpl.ads.banner.max;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class MainActivity extends AppCompatActivity implements MaxAdViewAdListener {
    private MaxAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make sure to set the mediation provider value to "max" to ensure proper functionality
        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                adView = findViewById(R.id.adView);

                // Load the ad
                adView.loadAd();

                // AppLovin SDK is initialized, start loading ads
                adView.setVisibility( View.VISIBLE );
                adView.startAutoRefresh();
            }
        } );
    }

    // MAX Ad Listener
    @Override
    public void onAdLoaded(final MaxAd maxAd) {}

    @Override
    public void onAdLoadFailed(final String adUnitId, final MaxError error) {}

    @Override
    public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error) {}

    @Override
    public void onAdClicked(final MaxAd maxAd) {}

    @Override
    public void onAdExpanded(final MaxAd maxAd) {}

    @Override
    public void onAdCollapsed(final MaxAd maxAd) {}

    @Override
    public void onAdDisplayed(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }

    @Override
    public void onAdHidden(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }
}