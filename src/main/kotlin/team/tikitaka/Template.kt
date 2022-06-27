package team.tikitaka

import com.android.tools.idea.wizard.template.*
import team.tikitaka.extension.generateFile
import team.tikitaka.extension.setupTemplateInfo

fun template(templateType: TemplateType) = template {
    setupTemplateInfo(templateType)

    val packageName = defaultPackageStringParameter()
    val className = classStringParameter()
    val layoutName = layoutStringParameter(className, templateType)
    val filePackageName = filePackageStringParameter()

    widgets(
        TextFieldWidget(packageName),
        TextFieldWidget(className),
        TextFieldWidget(layoutName),
        PackageNameWidget(filePackageName)
    )

    recipe = { data: TemplateData ->
        generateFile(
            data as ModuleTemplateData,
            templateType,
            packageName.value,
            className.value,
            layoutName.value,
            filePackageName.value
        )
    }
}
