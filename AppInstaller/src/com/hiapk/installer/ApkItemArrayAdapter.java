package com.hiapk.installer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import dalvik.annotation.Signature;
import java.util.ArrayList;

public class ApkItemArrayAdapter extends BaseAdapter
  implements View.OnClickListener
{
  private static final int MB_SIZE = 1024;
  private Context context;
  private int mCount;
  private LayoutInflater mInflater;

  @Signature({"Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;"})
  private ArrayList mItems = null;
  private boolean mShowState = true;

  @Signature({"(", "Landroid/content/Context;", "Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;Z)V"})
  public ApkItemArrayAdapter(Context paramContext, ArrayList paramArrayList, boolean paramBoolean)
  {
    this.context = paramContext;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.context);
    this.mInflater = localLayoutInflater;
    this.mCount = null;
    this.mItems = paramArrayList;
    this.mShowState = paramBoolean;
  }

  public int getCount()
  {
    return this.mItems.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mItems.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getSelectedCount()
  {
    return this.mCount;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView1;
    label19: ImageView localImageView1;
    TextView localTextView2;
    TextView localTextView3;
    TextView localTextView4;
    CheckBox localCheckBox1;
    ApkItem localApkItem;
    if (paramView == null)
    {
      localView1 = this.mInflater.inflate(2130903040, null);
      paramView = localView1;
      View localView2 = paramView;
      int i = 2131034112;
      localImageView1 = (ImageView)localView2.findViewById(i);
      View localView3 = paramView;
      int j = 2131034113;
      ImageView localImageView2 = (ImageView)localView3.findViewById(j);
      View localView4 = paramView;
      int k = 2131034114;
      TextView localTextView1 = (TextView)localView4.findViewById(k);
      View localView5 = paramView;
      int l = 2131034116;
      localTextView2 = (TextView)localView5.findViewById(l);
      View localView6 = paramView;
      int i1 = 2131034115;
      localTextView3 = (TextView)localView6.findViewById(i1);
      View localView7 = paramView;
      int i2 = 2131034118;
      localTextView4 = (TextView)localView7.findViewById(i2);
      View localView8 = paramView;
      int i3 = 2131034119;
      localCheckBox1 = (CheckBox)localView8.findViewById(i3);
      ArrayList localArrayList = this.mItems;
      int i4 = paramInt;
      localApkItem = (ApkItem)localArrayList.get(i4);
      localImageView1.setVisibility(0);
      switch (localApkItem.state)
      {
      default:
        label212: Drawable localDrawable1 = localApkItem.drawable;
        localImageView2.setImageDrawable(localDrawable1);
        String str1 = localApkItem.name;
        StringBuilder localStringBuilder1 = new StringBuilder(str1);
        if (!TextUtils.isEmpty(localApkItem.versionName))
        {
          localStringBuilder1.append("  ");
          String str2 = localApkItem.versionName;
          localStringBuilder1.append(str2);
        }
        if (localApkItem.versionCode > 0)
        {
          localStringBuilder1.append("  Build ");
          int i5 = localApkItem.versionCode;
          localStringBuilder1.append(i5);
        }
        String str3 = localStringBuilder1.toString();
        localTextView1.setText(str3);
        if (localApkItem.size < 1024)
          break label687;
        int i6 = localApkItem.size / 1024;
        int i7 = localApkItem.size;
        int i8 = i6 * 1024 * 1000 / 1024;
        int i9 = i7 - i8;
        String str4 = i6 + "." + i9 + "MB";
        localTextView4.setText(str4);
      case -1:
      case 0:
      case 1:
      }
    }
    while (true)
    {
      Integer localInteger = Integer.valueOf(paramInt);
      localCheckBox1.setTag(localInteger);
      CheckBox localCheckBox2 = localCheckBox1;
      ApkItemArrayAdapter localApkItemArrayAdapter = this;
      localCheckBox2.setOnClickListener(localApkItemArrayAdapter);
      return paramView;
      localView1 = paramView;
      break label19:
      if (this.mShowState)
      {
        Drawable localDrawable2 = localView1.getResources().getDrawable(17301533);
        localImageView1.setImageDrawable(localDrawable2);
      }
      while (true)
      {
        String str5 = localApkItem.path;
        localTextView2.setText(str5);
        localTextView3.setText(2130968584);
        localApkItem.check = null;
        localCheckBox1.setEnabled(null);
        localCheckBox1.setChecked(null);
        break label212:
        localImageView1.setVisibility(8);
      }
      if (this.mShowState)
      {
        Drawable localDrawable3 = localView1.getResources().getDrawable(17301619);
        localImageView1.setImageDrawable(localDrawable3);
      }
      while (true)
      {
        String str6 = localApkItem.path;
        localTextView2.setText(str6);
        localTextView3.setText(2130968584);
        boolean bool1 = localApkItem.check;
        localCheckBox1.setChecked(bool1);
        localCheckBox1.setEnabled(true);
        break label212:
        localImageView1.setVisibility(8);
      }
      if (this.mShowState)
      {
        Drawable localDrawable4 = localView1.getResources().getDrawable(17301618);
        localImageView1.setImageDrawable(localDrawable4);
      }
      while (true)
      {
        String str7 = localApkItem.packageName;
        localTextView2.setText(str7);
        localTextView3.setText(2130968587);
        boolean bool2 = localApkItem.check;
        localCheckBox1.setChecked(bool2);
        localCheckBox1.setEnabled(true);
        break label212:
        localImageView1.setVisibility(8);
      }
      label687: StringBuilder localStringBuilder2 = new StringBuilder();
      int i10 = localApkItem.size;
      String str8 = i10 + "KB";
      localTextView4.setText(str8);
    }
  }

  public boolean isClicked(int paramInt)
  {
    return ((ApkItem)this.mItems.get(paramInt)).check;
  }

  public void onClick(View paramView)
  {
    int i = 1;
    int j = ((Integer)paramView.getTag()).intValue();
    ApkItem localApkItem = (ApkItem)this.mItems.get(j);
    boolean bool = localApkItem.check;
    label41: int k;
    if (!bool)
    {
      bool = i;
      localApkItem.check = bool;
      if (!localApkItem.check)
        break label78;
      k = this.mCount;
      ++bool;
    }
    label78: int l;
    for (this.mCount = k; ; this.mCount = l)
    {
      return;
      Object localObject = null;
      break label41:
      l = this.mCount - i;
    }
  }

  @Signature({"(", "Ljava/util/ArrayList", "<", "Lcom/hiapk/installer/ApkItem;", ">;)V"})
  public void setItems(ArrayList paramArrayList)
  {
    this.mItems = paramArrayList;
    notifyDataSetChanged();
  }

  public void setSelectedCount(int paramInt)
  {
    this.mCount = paramInt;
  }
}

/* Location:           E:\Nigeland\Android_developing\dex2jar2java\软件卸载备份AppInstaller_v2_2_apk\classes.dex.dex2jar.jar
 * Qualified Name:     com.hiapk.installer.ApkItemArrayAdapter
 * JD-Core Version:    0.5.4
 */