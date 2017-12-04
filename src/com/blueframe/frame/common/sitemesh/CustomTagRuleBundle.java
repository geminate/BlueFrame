package com.blueframe.frame.common.sitemesh;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * 自定义 SiteMesh 标签 类
 * @author hhLiu
 */
public class CustomTagRuleBundle implements TagRuleBundle {

	@Override
	public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		defaultState.addRule("sitemesh:title", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:title"), false));
		defaultState.addRule("sitemesh:page_level_plugins_style",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:page_level_plugins_style"), false));
		defaultState.addRule("sitemesh:custom_style", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:custom_style"), false));
		defaultState.addRule("sitemesh:container", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:container"), false));
		defaultState.addRule("sitemesh:page_level_plugins_script",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:page_level_plugins_script"), false));
		defaultState.addRule("sitemesh:page_level_script", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:page_level_script"),
				false));
		defaultState.addRule("sitemesh:custom_script", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("sitemesh:custom_script"), false));

	}

	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
	}

}
