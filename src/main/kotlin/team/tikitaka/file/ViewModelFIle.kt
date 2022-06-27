package team.tikitaka.file

fun viewModelFile(
    defaultPackage: String,
    filePackage: String,
    className: String
) = """
package $filePackage
import ${defaultPackage}.core.base.BaseViewModel
class ${className}ViewModel : BaseViewModel()
""".trimIndent()
