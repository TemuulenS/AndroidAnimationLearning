package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

public class FlyWithDogeAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
      ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
      positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
              float value = (float) animation.getAnimatedValue();
              mRocket.setTranslationY(value);
              mDoge.setTranslationY(value);
          }
      });

      ValueAnimator rotationAnimation = ValueAnimator.ofFloat(0, 360);
      rotationAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
              float value = (float) valueAnimator.getAnimatedValue();
              mDoge.setRotation(value);
          }
      });

      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.play(positionAnimator).with(rotationAnimation);
      animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
      animatorSet.start();
  }
}
