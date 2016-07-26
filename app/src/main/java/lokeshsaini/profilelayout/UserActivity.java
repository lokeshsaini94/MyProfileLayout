package lokeshsaini.profilelayout;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView mtvNumber1;
    TextView mtvNumber2;
    TextView mtvNumber3;
    TextView mtvNumber4;
    TextView mtvNumber5;
    TextView mtvNumber6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mtvNumber1 = (TextView) findViewById(R.id.tvNumber1);
        mtvNumber2 = (TextView) findViewById(R.id.tvNumber2);
        mtvNumber3 = (TextView) findViewById(R.id.tvNumber3);
        mtvNumber4 = (TextView) findViewById(R.id.tvNumber4);
        mtvNumber5 = (TextView) findViewById(R.id.tvNumber5);
        mtvNumber6 = (TextView) findViewById(R.id.tvNumber6);

        mtvNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "(123) 456-7890"));
                if (ActivityCompat.checkSelfPermission(UserActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    ActivityCompat.requestPermissions(UserActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE},
                            1);
                    return;
                }
                startActivity(intent);
            }
        });

        mtvNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "(321) 654-0987"));
                if (ActivityCompat.checkSelfPermission(UserActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    ActivityCompat.requestPermissions(UserActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE},
                            1);
                    return;
                }
                startActivity(intent);
            }
        });

        mtvNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "bastard@jonsnow.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mtvNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "commander@jonsnow.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mtvNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=Winterfell"));
                startActivity(intent);
            }
        });

        mtvNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=Night's Watch"));
                startActivity(intent);
            }
        });

    }
}
