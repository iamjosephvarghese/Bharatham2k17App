package com.roundmelon.jv.bharatham2k17;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Updates1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final private int STORAGE_PERMISSION_CODE = 23;
    private static long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("CHAVARA HALL"));
        tabLayout.addTab(tabLayout.newTab().setText("GALLERY HALL"));
        tabLayout.addTab(tabLayout.newTab().setText("PAREEKSHA BHAVAN H1"));
        tabLayout.addTab(tabLayout.newTab().setText("PAREEKSHA BHAVAN H2"));
        tabLayout.addTab(tabLayout.newTab().setText("PAREEKSHA BHAVAN H3"));
        tabLayout.addTab(tabLayout.newTab().setText("PAREEKSHA BHAVAN H4"));
        tabLayout.addTab(tabLayout.newTab().setText("PAREEKSHA BHAVAN H5"));
        tabLayout.addTab(tabLayout.newTab().setText("OPEN STAGE"));
        tabLayout.addTab(tabLayout.newTab().setText("LECTURE HALL"));
        tabLayout.addTab(tabLayout.newTab().setText("LECTURE HALL"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);




        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //            super.onBackPressed();

            if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
            else Snackbar.make(findViewById(R.id.rootView),"Press Once More To Exit.", Snackbar.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent homeIntent = new Intent(this,HomeActivity.class);
            startActivity(homeIntent);
            finish();
        } else if (id == R.id.nav_scores) {
            //Intent scoreIntet = new Intent(this,Score2.class);
            Intent scoreIntet = new Intent(this,Chart1.class);
            startActivity(scoreIntet);
            finish();

        }
        else if (id == R.id.nav_updates) {
            Intent updateIntent = new Intent(this,Score.class);
            startActivity(updateIntent);
            finish();

        }
        else if (id == R.id.nav_badge) {
            if(isWriteStorageAllowed()){

                Intent fbIntent = new Intent(this,Fb.class);
                startActivity(fbIntent);


            }

            //If the app has not the permission then asking for the permission
            requestStoragePermission();

        }
//        else if (id == R.id.nav_selfie) {
//            Intent selfieIntent = new Intent(this,Selfie.class);
//            startActivity(selfieIntent);
//
//        } else if (id == R.id.nav_selfiegallery) {
//            Intent  selfieGalleryintent = new Intent(this,SelfieGallery.class);
//            startActivity(selfieGalleryintent);
//        }
        else if (id == R.id.nav_videos){
            Intent galleryIntent = new Intent(this,Video1.class);
            startActivity(galleryIntent);
            //
        }
        else if (id == R.id.nav_website){
//            Intent galleryIntent = new Intent(this,Web.class);
//            startActivity(galleryIntent);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bharatham2k17.com")));
            //
        }
        else if (id == R.id.nav_schedule){
            Intent galleryIntent = new Intent(this,Updates1.class);
            startActivity(galleryIntent);
            finish();

        }
        else if (id == R.id.nav_gallery){
            Intent galleryIntent = new Intent(this,Gallery1.class);
            startActivity(galleryIntent);
            finish();
            //
        }else if (id == R.id.nav_facebook){
            try {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1855389091393568"));
                startActivity(intent);
            } catch (Exception e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bharatham2017")));
            }
        }else if(id == R.id.nav_instagram){
            //change page id
            Uri uri = Uri.parse("http://instagram.com/_u/bharatham2017");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/bharatham2017/?hl=en")));
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private boolean isWriteStorageAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }
    //Requesting permission
    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            Toast.makeText(this,"This permission is required to store the badge on your device.",Toast.LENGTH_LONG).show();
        }

        ActivityCompat.requestPermissions((Activity)this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_CODE : {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent fbIntent = new Intent(this,Fb.class);
                    startActivity(fbIntent);


                } else {
                    Toast.makeText(this,"Please grant the permission to access this feature.",Toast.LENGTH_LONG).show();

                }
                return;
            }


        }
    }
}

