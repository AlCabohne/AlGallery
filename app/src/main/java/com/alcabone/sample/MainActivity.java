package com.alcabone.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alcabone.gesturegallery.GalleryBuilder;
import com.alcabone.gesturegallery.GalleryConstants;
import com.alcabone.gesturegallery.GridBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    public void gridActivity(View v)
    {
        GridBuilder.withURL(this, getDummyImageList())
                .setTitle("Damage Templates")
//                .setToolbarTitleColor(R.color.colorAccent)
                .setShowBackButton(GalleryConstants.GalleryOptions.BACK_BUTTON_WHITE)
                .setSpanCount(3)
                .setGridImgPlaceHolder(R.color.colorPrimary)
                .show();
    }

    public void galleryActivity(View v)
    {
        GalleryBuilder.withUrls(this, getDummyImageList())
//                .setToolbarTitleColor(R.color.colorAccent)
                .setShowBackButton(GalleryConstants.GalleryOptions.BACK_BUTTON_WHITE)
                .setFullscreenMode(false)
                .setTitle("Damage Templates")
                .show();
    }

    private ArrayList<Integer> getDummyIDList()
    {
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(R.drawable.dmg_truck);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_bus);
        idList.add(R.drawable.dmg_kit);
        idList.add(R.drawable.dmg_trailer);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_truck2);
        idList.add(R.drawable.dmg_truck2);
        return idList;
    }

    private ArrayList<String> getDummyImageList()
    {
        ArrayList<String> imagesList = new ArrayList<>();
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05110349/20160731-igor-trepeshchenok-barnimages-08-768x509.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095154/tumblr_oawfisUmZo1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obbkeo3lZW1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obaxpnJbKg1sfie3io1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obdehwWneK1slhhf0o1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095152/2016-08-01-roman-drits-barnimages-005-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095151/2016-08-01-roman-drits-barnimages-003-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095149/tumblr_obbjwp1bDz1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095151/tumblr_oawfhnxNjL1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095150/tumblr_ob6xvqXLoB1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095148/20160731-igor-trepeshchenok-barnimages-10-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092421/tumblr_oawfgd2G941u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092423/tumblr_ob6xutS8N21tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092421/tumblr_o86sgm6F7a1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/tumblr_ob6xudqW4U1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/2016-08-01-roman-drits-barnimages-002-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092418/tumblr_o97fatuGnd1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/tumblr_oawff12j9L1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/2016-08-01-roman-drits-barnimages-001-768x512.jpg");
        imagesList.add("http://1x402i15i5vh15yage3fafmg.wpengine.netdna-cdn.com/wp-content/uploads/2016/08/tumblr_oawfdsEx2w1u7ns0go1_500-1.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092417/tumblr_o97gyqSK3k1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092417/20160731-igor-trepeshchenok-barnimages-07-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092605/tumblr_ob6wjiCBUh1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092604/tumblr_ob6wkn58cJ1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092416/tumblr_ob6wk7mns81tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092413/tumblr_ob6vv04yIP1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092414/tumblr_ob6vk1bBPa1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092404/tumblr_o97ipvkger1ted1sho1_500.jpg");
        return imagesList;
    }
}
