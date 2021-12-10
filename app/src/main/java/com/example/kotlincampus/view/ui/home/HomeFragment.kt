package com.example.kotlincampus.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.base.base.BaseFragment
import com.example.base.util.launchAndCollect
import com.example.kotlincampus.databinding.FragmentHomeBinding
import com.example.kotlincampus.entity.BannerEntity
import com.example.kotlincampus.net.Constants
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator


class HomeFragment : BaseFragment() {

    private val model: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
    }

    private fun initBanner() {
        binding.banner.setBannerRound(20F)
        launchAndCollect({ model.getBannerList(Constants.banner_type) }) {
            onSuccess = {
                it?.let {
                    initUserBanner(it)
                }

            }
        }
    }

    /**
     * banner占位图广告位
     */
    private fun initUserBanner(list: List<BannerEntity>) {
        binding.banner.setAdapter(object : BannerImageAdapter<BannerEntity>(list) {
            override fun onBindView(
                holder: BannerImageHolder,
                data: BannerEntity,
                position: Int,
                size: Int
            ) {
                Glide.with(holder.itemView).load(data.hrefUrl).into(holder.imageView)
            }
        })
            .setIndicator(CircleIndicator(context))
            .addBannerLifecycleObserver(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}