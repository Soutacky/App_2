package jp.co.meijou.android.s221205099;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;

import java.util.stream.Collectors;

import jp.co.meijou.android.s221205099.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;
    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        connectivityManager = getSystemService(ConnectivityManager.class);

        var currentNetwork = connectivityManager.getActiveNetwork();

        updateTransport(currentNetwork);
        updateIpAddress(currentNetwork);
    }

    private void updateTransport(Network network) {
        var caps =connectivityManager.getNetworkCapabilities(network);

        if (caps != null) {
            String transport;
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                transport = "モバイル通信";
            } else if (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                transport = "WiFi";
            } else {
                transport = "その他";
            }

            binding.transportName.setText(transport);
        }
    }

    private void updateIpAddress(Network network) {
        var linkProperties = connectivityManager.getLinkProperties(network);

        if (linkProperties != null) {
            var addresses = linkProperties.getLinkAddresses().stream()
                    .map(LinkAddress::toString)
                    .collect(Collectors.joining("\n"));

            binding.textView8.setText(addresses);
        }
    }

    private void registerNetworkCallback() {
        connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);
                runOnUiThread(() -> {
                    updateTransport(network);
                    updateIpAddress(network);
                });
            }
        });
    }
}