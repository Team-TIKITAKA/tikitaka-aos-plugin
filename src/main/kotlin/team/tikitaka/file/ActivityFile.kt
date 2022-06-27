package team.tikitaka.file

import team.tikitaka.extension.camelToSnakeCase

fun activityFile(
    defaultPackage: String,
    filePackage: String,
    className: String
) = """
package $filePackage
import android.os.Bundle
import ${defaultPackage}.core.base.BaseActivity
import ${defaultPackage}.core.base.BaseViewArgument
import ${defaultPackage}.core.provider.DataBindingProvider
import ${defaultPackage}.databinding.Activity${className}Binding
class ${className}Activity : BaseActivity() {
    override val argument = BaseViewArgument.DataBinding(
        R.layout.activity_${className.camelToSnakeCase()},
        DataBindingProvider<Activity${className}Binding>()
    )
    private val binding: Activity${className}Binding by lazy {
        argument.bindingProvider.binding
    }
}
""".trimIndent()
