package com.example.backpackstore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;

public class ProductDetailActivity extends AppCompatActivity {

    private static final String TAG = "ProductDetailActivity";
    private VrPanoramaView panoramaView;
    private VrPanoramaView.Options panoramaOptions; // Will be configured later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        panoramaView = findViewById(R.id.panorama_view);
        panoramaView.setEventListener(new ActivityEventListener());

        // Panorama loading options.
        // For now, just initialize. Type (mono/stereo) will be set when loading an image.
        panoramaOptions = new VrPanoramaView.Options();
        // panoramaOptions.inputType = VrPanoramaView.Options.TYPE_MONO; // Example

        // TODO: Load actual image here in a later step
        // For now, you could load a placeholder or leave it blank.
        // Example: loadSamplePanorama();
    }

    // We will implement image loading later
    // private void loadSamplePanorama() {
    //     // Asset loading logic will go here
    // }

    @Override
    protected void onResume() {
        super.onResume();
        if (panoramaView != null) {
            panoramaView.resumeRendering();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (panoramaView != null) {
            panoramaView.pauseRendering();
        }
    }

    @Override
    protected void onDestroy() {
        if (panoramaView != null) {
            panoramaView.shutdown();
        }
        super.onDestroy();
    }

    private class ActivityEventListener extends VrPanoramaEventListener {
        @Override
        public void onLoadSuccess() {
            Log.i(TAG, "Panorama loaded successfully.");
        }

        @Override
        public void onLoadError(String errorMessage) {
            Log.e(TAG, "Error loading panorama: " + errorMessage);
            Toast.makeText(ProductDetailActivity.this, "Error loading panorama: " + errorMessage, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onClick() {
            super.onClick();
            Log.i(TAG, "Panorama clicked.");
            // Handle click if needed, e.g., toggle UI elements
        }

        @Override
        public void onDisplayModeChanged(int newDisplayMode) {
            super.onDisplayModeChanged(newDisplayMode);
            Log.i(TAG, "Display mode changed to: " + newDisplayMode);
        }
    }
}
