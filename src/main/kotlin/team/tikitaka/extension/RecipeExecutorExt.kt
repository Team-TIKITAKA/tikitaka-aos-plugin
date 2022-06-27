package team.tikitaka.extension

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import team.tikitaka.TemplateType
import team.tikitaka.file.activityFile
import team.tikitaka.file.fragmentFile
import team.tikitaka.file.layoutFile
import team.tikitaka.file.viewModelFile

fun RecipeExecutor.generateFile(
    moduleData: ModuleTemplateData,
    templateType: TemplateType,
    packageName: String,
    className: String,
    layoutName: String,
    fileName: String
) {
    val (_, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)

    srcOut.resolve("")
    resOut.resolve("")

    if (templateType == TemplateType.ACTIVITY) {

        save(
            activityFile(packageName, fileName, className),
            srcOut.resolve("${className}ActivityFile.kt")
        )
    } else {

        save(
            fragmentFile(packageName, fileName, className),
            srcOut.resolve("${className}Fragment.kt")
        )
    }

    save(
        viewModelFile(packageName, fileName, className),
        srcOut.resolve("${className}ViewModel.kt")
    )

    save(
        layoutFile(),
        resOut.resolve("layout/${layoutName}.xml")
    )
}
