package com.apk.easyinstall;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ScanProgressDialog extends Dialog
{
  private TextView mMessageView;
  private ProgressBar mProgress;

  public ScanProgressDialog(Context paramContext)
  {
    super(paramContext);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903043);
    TextView localTextView = (TextView)findViewById(2131034122);
    this.mMessageView = localTextView;
    this.mMessageView.setText(2130968579);
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131034121);
    this.mProgress = localProgressBar;
  }

  public void setMessage(String paramString)
  {
    this.mMessageView.setText(paramString);
  }

  public void setProgress(int paramInt)
  {
    this.mProgress.setProgress(paramInt);
  }
}