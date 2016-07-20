// Generated code from Butter Knife. Do not modify!
package com.lxj.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ServiceFragment$$ViewBinder<T extends com.lxj.fragment.ServiceFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493004, "field 'fragmentIv1'");
    target.fragmentIv1 = finder.castView(view, 2131493004, "field 'fragmentIv1'");
    view = finder.findRequiredView(source, 2131493005, "field 'fragmentIv2'");
    target.fragmentIv2 = finder.castView(view, 2131493005, "field 'fragmentIv2'");
    view = finder.findRequiredView(source, 2131493006, "field 'fragmentIv3'");
    target.fragmentIv3 = finder.castView(view, 2131493006, "field 'fragmentIv3'");
    view = finder.findRequiredView(source, 2131493007, "field 'fragmentIv4'");
    target.fragmentIv4 = finder.castView(view, 2131493007, "field 'fragmentIv4'");
    view = finder.findRequiredView(source, 2131493008, "field 'fragmentIv5'");
    target.fragmentIv5 = finder.castView(view, 2131493008, "field 'fragmentIv5'");
    view = finder.findRequiredView(source, 2131493009, "field 'fragmentIv6'");
    target.fragmentIv6 = finder.castView(view, 2131493009, "field 'fragmentIv6'");
    view = finder.findRequiredView(source, 2131493010, "field 'profileImage'");
    target.profileImage = finder.castView(view, 2131493010, "field 'profileImage'");
  }

  @Override public void unbind(T target) {
    target.fragmentIv1 = null;
    target.fragmentIv2 = null;
    target.fragmentIv3 = null;
    target.fragmentIv4 = null;
    target.fragmentIv5 = null;
    target.fragmentIv6 = null;
    target.profileImage = null;
  }
}
