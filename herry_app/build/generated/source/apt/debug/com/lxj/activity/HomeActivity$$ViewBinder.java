// Generated code from Butter Knife. Do not modify!
package com.lxj.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomeActivity$$ViewBinder<T extends com.lxj.activity.HomeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492972, "field 'acHomeFlContent'");
    target.acHomeFlContent = finder.castView(view, 2131492972, "field 'acHomeFlContent'");
    view = finder.findRequiredView(source, 2131492975, "field 'acHomeIvHome'");
    target.acHomeIvHome = finder.castView(view, 2131492975, "field 'acHomeIvHome'");
    view = finder.findRequiredView(source, 2131492976, "field 'acHomeTvHome'");
    target.acHomeTvHome = finder.castView(view, 2131492976, "field 'acHomeTvHome'");
    view = finder.findRequiredView(source, 2131492974, "field 'acHomeLlHome' and method 'onClick'");
    target.acHomeLlHome = finder.castView(view, 2131492974, "field 'acHomeLlHome'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492978, "field 'acHomeIvMy'");
    target.acHomeIvMy = finder.castView(view, 2131492978, "field 'acHomeIvMy'");
    view = finder.findRequiredView(source, 2131492979, "field 'acHomeTvMy'");
    target.acHomeTvMy = finder.castView(view, 2131492979, "field 'acHomeTvMy'");
    view = finder.findRequiredView(source, 2131492977, "field 'acHomeLlMy' and method 'onClick'");
    target.acHomeLlMy = finder.castView(view, 2131492977, "field 'acHomeLlMy'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492981, "field 'acHomeIvService'");
    target.acHomeIvService = finder.castView(view, 2131492981, "field 'acHomeIvService'");
    view = finder.findRequiredView(source, 2131492982, "field 'acHomeTvService'");
    target.acHomeTvService = finder.castView(view, 2131492982, "field 'acHomeTvService'");
    view = finder.findRequiredView(source, 2131492980, "field 'acHomeLlService' and method 'onClick'");
    target.acHomeLlService = finder.castView(view, 2131492980, "field 'acHomeLlService'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492984, "field 'acHomeIvService2'");
    target.acHomeIvService2 = finder.castView(view, 2131492984, "field 'acHomeIvService2'");
    view = finder.findRequiredView(source, 2131492985, "field 'acHomeTvService2'");
    target.acHomeTvService2 = finder.castView(view, 2131492985, "field 'acHomeTvService2'");
    view = finder.findRequiredView(source, 2131492983, "field 'acHomeLlService2' and method 'onClick'");
    target.acHomeLlService2 = finder.castView(view, 2131492983, "field 'acHomeLlService2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492973, "field 'll'");
    target.ll = finder.castView(view, 2131492973, "field 'll'");
  }

  @Override public void unbind(T target) {
    target.acHomeFlContent = null;
    target.acHomeIvHome = null;
    target.acHomeTvHome = null;
    target.acHomeLlHome = null;
    target.acHomeIvMy = null;
    target.acHomeTvMy = null;
    target.acHomeLlMy = null;
    target.acHomeIvService = null;
    target.acHomeTvService = null;
    target.acHomeLlService = null;
    target.acHomeIvService2 = null;
    target.acHomeTvService2 = null;
    target.acHomeLlService2 = null;
    target.ll = null;
  }
}
