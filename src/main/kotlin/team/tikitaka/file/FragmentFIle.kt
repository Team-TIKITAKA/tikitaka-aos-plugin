package team.tikitaka.file

fun fragmentFile(
    defaultPackage: String,
    filePackage: String,
    className: String
) = """
package $filePackage
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ${defaultPackage}.core.base.BaseFragment
import ${defaultPackage}.core.base.BaseViewArgument
import ${defaultPackage}.core.provider.DataBindingProvider
import ${defaultPackage}.databinding.Fragment${className}Binding
class ${className}Fragment : BaseFragment() {
    override val argument = BaseViewArgument.DataBinding(
        R.layout.fragment_${className.lowercase()},
        DataBindingProvider<Fragment${className}Binding>()
    )
    private val binding: Fragment${className}Binding by lazy {
        argument.bindingProvider.binding
    }
}
""".trimIndent()
