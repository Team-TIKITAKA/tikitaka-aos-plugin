package team.tikitaka

import com.android.tools.idea.wizard.template.*

private const val DEFAULT_PACKAGE = "com.parkjin.template"

fun defaultPackageStringParameter() = stringParameter {
    name = "Default Package"
    visible = { isNewModule.not() }
    default = DEFAULT_PACKAGE
    constraints = listOf(Constraint.PACKAGE)
}

fun classStringParameter() = stringParameter {
    name = "Class Name"
    default = ""
    constraints = listOf(
        Constraint.NONEMPTY
    )
}

fun layoutStringParameter(className: StringParameter, templateType: TemplateType) = stringParameter {
    name = "Layout Name"
    default = ""
    constraints = listOf(
        Constraint.LAYOUT,
        Constraint.UNIQUE,
        Constraint.NONEMPTY
    )
    suggest = {
        val name = className.value.lowercase()
        if (templateType == TemplateType.ACTIVITY) activityToLayout(name) else fragmentToLayout(name)
    }
}

fun filePackageStringParameter() = stringParameter {
    name = "File Package"
    visible = { isNewModule.not() }
    default = DEFAULT_PACKAGE
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
}
