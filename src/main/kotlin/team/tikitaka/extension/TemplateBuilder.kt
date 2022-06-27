package team.tikitaka.extension

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.TemplateBuilder
import com.android.tools.idea.wizard.template.WizardUiContext
import team.tikitaka.TemplateType

fun TemplateBuilder.setupTemplateInfo(templateType: TemplateType) {
    name = "Template ${templateType.name}"
    description = "Creates a new template ${templateType.name}"
    minApi = 21
    category = if (templateType == TemplateType.ACTIVITY) Category.Activity else Category.Fragment
    formFactor = FormFactor.Mobile
    screens = listOf(
        if (templateType == TemplateType.ACTIVITY) WizardUiContext.ActivityGallery else WizardUiContext.FragmentGallery,
        WizardUiContext.MenuEntry,
        WizardUiContext.NewProject,
        WizardUiContext.NewModule
    )
}
