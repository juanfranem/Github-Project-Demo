package es.jfechevarria.application.ui.viewHolders

import es.jfechevarria.application.core.BaseViewHolder
import es.jfechevarria.application.databinding.ItemUserBinding
import es.jfechevarria.application.ui.extensions.load
import es.jfechevarria.application.ui.interfaces.UserInteractor
import es.jfechevarria.domain.user.User

class UserViewHolder(
    private val userInteractor: UserInteractor,
    private val binding: ItemUserBinding
): BaseViewHolder<User>(binding) {
    override fun bind(item: User) {
        binding.image.load(item.image)
        binding.username.text = item.userName
        binding.root.setOnClickListener {
            userInteractor.onUserClick(item)
        }
    }
}